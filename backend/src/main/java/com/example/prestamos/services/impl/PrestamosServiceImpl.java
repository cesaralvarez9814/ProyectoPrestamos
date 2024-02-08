package com.example.prestamos.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prestamos.dto.ClienteDTO;
import com.example.prestamos.dto.MontoDTO;
import com.example.prestamos.dto.PlazoDTO;
import com.example.prestamos.dto.RespuestaPrestamoDTO;
import com.example.prestamos.dto.RespuestaTablaDTO;
import com.example.prestamos.dto.TablaDTO;
import com.example.prestamos.entity.Cliente;
import com.example.prestamos.entity.Monto;
import com.example.prestamos.entity.Plazo;
import com.example.prestamos.entity.Prestamos;
import com.example.prestamos.mappers.ClienteMapper;
import com.example.prestamos.mappers.MontoMapper;
import com.example.prestamos.mappers.PlazoMapper;
import com.example.prestamos.repository.ClienteRepository;
import com.example.prestamos.repository.MontoRepository;
import com.example.prestamos.repository.PlazoRepository;
import com.example.prestamos.repository.PrestamoRepository;
import com.example.prestamos.services.PrestamosService;


@Service
public class PrestamosServiceImpl implements PrestamosService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private MontoRepository montoRepository;
    @Autowired
    private PlazoRepository plazoRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;

    @Override
    public void createCliente(ClienteDTO c) {
        Cliente cliente = ClienteMapper.mapClienteDTO(c);
        clienteRepository.save(cliente);
    }
    @Override
    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }
    @Override
    public void createMonto(MontoDTO m) {
        Monto monto = MontoMapper.mapMontoDTO(m);
        montoRepository.save(monto);
    }
    @Override
    public List<Monto> getMontos(){
        return montoRepository.findAll();
    }
    @Override
    public void createPlazo(PlazoDTO p) {
        Plazo plazo = PlazoMapper.mapPlazoDTO(p);
        plazoRepository.save(plazo);
    }
    @Override
    public List<Plazo> getPlazos(){
        return plazoRepository.findAll();
    }
    @Override
    public void createPrestamo(Prestamos p) {
        p.setFechaPrestamo(this.getFecha());
        prestamoRepository.save(p);
    }
    @Override
    public List<RespuestaPrestamoDTO> getPrestamos() {
        List<RespuestaPrestamoDTO> list = new ArrayList<RespuestaPrestamoDTO>();
        prestamoRepository.findAll().forEach((Prestamos p) -> {
            list.add(new RespuestaPrestamoDTO(p.getId(),p.getCliente().getFirstName()+ ' '+ p.getCliente().getLastName(),
            p.getMonto().getValor(),p.getPlazo().getValor()));
        });;
        return list;
    }
    @Override
    public RespuestaTablaDTO getTablaAmortizacion(Integer id) {
        int cont,monto,plazo;
        double valorPrestamo,interes,sumInteres=0,sumAbono=0;
        List<TablaDTO> list = new ArrayList<TablaDTO>();
        cont=1;
        Prestamos p = prestamoRepository.getReferenceById(id);
        LocalDate date1 = LocalDate.parse(p.getFechaPrestamo());
        monto = p.getMonto().getValor();
        plazo = p.getPlazo().getValor();
        valorPrestamo =monto/plazo;
        interes= new BigDecimal(monto * .011).setScale(2,RoundingMode.HALF_UP).doubleValue(); //Se puede ligar un interes al plazo, se le puso el 11% por defecto
        do{
            TablaDTO t = new TablaDTO(cont, date1.toString(), valorPrestamo, interes, valorPrestamo+interes);
            list.add(t);
            sumInteres+=interes;
            sumAbono+= valorPrestamo+interes;
            cont++;
            date1=date1.plusDays(15);
        }while(cont<=plazo);
        RespuestaTablaDTO resp = new RespuestaTablaDTO();
        resp.setNumPagos(plazo);
        resp.setNombreCliente(p.getCliente().getFirstName() + ' ' + p.getCliente().getLastName());
        resp.setValores(list);
        resp.setSumPrestamo(monto);
        resp.setSumInteres(new BigDecimal(sumInteres).setScale(2,RoundingMode.HALF_UP).doubleValue());
        resp.setSumAbono(new BigDecimal(sumAbono).setScale(2,RoundingMode.HALF_UP).doubleValue());
        return resp;
    }

    public String  getFecha(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }

}

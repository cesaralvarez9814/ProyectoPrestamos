export class Alert {
    type: AlertType = 0;
    message: string ='';
    alertId: string='';
    keepAfterRouteChange: boolean=true;

    constructor(init?:Partial<Alert>) {
        Object.assign(this, init);
    }
}

export enum AlertType {
    Success,
    Error,
    Info,
    Warning
}
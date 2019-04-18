import { IPeriod } from 'app/shared/model/period.model';

export interface IProject {
    id?: number;
    name?: string;
    schedule?: string;
    status?: string;
    period?: IPeriod;
}

export class Project implements IProject {
    constructor(public id?: number, public name?: string, public schedule?: string, public status?: string, public period?: IPeriod) {}
}

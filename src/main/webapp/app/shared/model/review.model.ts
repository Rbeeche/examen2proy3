import { Moment } from 'moment';
import { IStudent } from 'app/shared/model/student.model';
import { IStory } from 'app/shared/model/story.model';

export interface IReview {
    id?: number;
    timeStamp?: Moment;
    comment?: string;
    status?: string;
    students?: IStudent[];
    story?: IStory;
}

export class Review implements IReview {
    constructor(
        public id?: number,
        public timeStamp?: Moment,
        public comment?: string,
        public status?: string,
        public students?: IStudent[],
        public story?: IStory
    ) {}
}

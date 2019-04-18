import { ITeam } from 'app/shared/model/team.model';
import { IStory } from 'app/shared/model/story.model';
import { IReview } from 'app/shared/model/review.model';

export interface IStudent {
    id?: number;
    name?: string;
    lastName?: string;
    role?: string;
    status?: string;
    team?: ITeam;
    story?: IStory;
    review?: IReview;
}

export class Student implements IStudent {
    constructor(
        public id?: number,
        public name?: string,
        public lastName?: string,
        public role?: string,
        public status?: string,
        public team?: ITeam,
        public story?: IStory,
        public review?: IReview
    ) {}
}

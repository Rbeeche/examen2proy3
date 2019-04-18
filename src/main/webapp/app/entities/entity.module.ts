import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'period',
                loadChildren: './period/period.module#Examen2Proy3PeriodModule'
            },
            {
                path: 'project',
                loadChildren: './project/project.module#Examen2Proy3ProjectModule'
            },
            {
                path: 'team',
                loadChildren: './team/team.module#Examen2Proy3TeamModule'
            },
            {
                path: 'student',
                loadChildren: './student/student.module#Examen2Proy3StudentModule'
            },
            {
                path: 'sprint',
                loadChildren: './sprint/sprint.module#Examen2Proy3SprintModule'
            },
            {
                path: 'story',
                loadChildren: './story/story.module#Examen2Proy3StoryModule'
            },
            {
                path: 'review',
                loadChildren: './review/review.module#Examen2Proy3ReviewModule'
            }
            /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
        ])
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Examen2Proy3EntityModule {}

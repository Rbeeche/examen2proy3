import { NgModule } from '@angular/core';

import { Examen2Proy3SharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [Examen2Proy3SharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [Examen2Proy3SharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class Examen2Proy3SharedCommonModule {}

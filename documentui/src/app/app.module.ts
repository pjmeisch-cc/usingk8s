import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import {SearchComponent} from './search.component';
import {DetailComponent} from './detail.component';
import {AddComponent} from './add.component';

const appRoutes: Routes = [
  { path: 'search', component: SearchComponent },
  { path: 'detail', component: DetailComponent},
  { path: 'add', component: AddComponent},
  { path: '', redirectTo: '/search', pathMatch: 'full'},
  { path: '**', redirectTo: '/search', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    DetailComponent,
    AddComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

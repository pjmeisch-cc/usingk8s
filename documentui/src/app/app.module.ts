// angular stuff
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
// this application's components
import {AppComponent} from './app.component';
import {ListComponent} from './list.component';
import {DetailComponent} from './detail.component';
import {AddComponent} from './add.component';

const appRoutes: Routes = [
  {path: 'list', component: ListComponent},
  {path: 'detail', component: DetailComponent},
  {path: 'detail/:id', component: DetailComponent},
  {path: 'add', component: AddComponent},
  {path: '**', redirectTo: '/list', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    DetailComponent,
    AddComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true} // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

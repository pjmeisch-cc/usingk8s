import {Component} from '@angular/core';
import {DocumentDataService} from './document-data.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [DocumentDataService]
})

export class AppComponent {
}

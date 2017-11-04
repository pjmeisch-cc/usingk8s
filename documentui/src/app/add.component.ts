import {Component} from '@angular/core';

import {DocumentData} from './document-data';
import {DocumentDataService} from './document-data.service';

@Component({
  selector: 'app-add-component',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  providers: [DocumentDataService]
})

export class AddComponent {
  documentData: DocumentData = new DocumentData();

  constructor(private documentDataService: DocumentDataService) {
  }

  onAddDocument() {
    if (this.documentData.isValid()) {
      console.log('should add ' + this.documentData);
      this.documentDataService.add(this.documentData);

      console.log(this.documentDataService.all());
    } else {
      console.log('no valid input data to add');
    }
  }
}

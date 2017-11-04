import {Component} from '@angular/core';
import {DocumentData} from './document-data';

@Component({
  selector: 'app-add-component',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})

export class AddComponent {
  documentData: DocumentData = new DocumentData();

  onAddDocument() {
    console.log('should add ' + this.documentData);
  }
}

import {Component, OnInit} from '@angular/core';
import {DocumentData} from './document-data';
import {DocumentDataService} from './document-data.service';

@Component({
  selector: 'app-list-component',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})

export class ListComponent implements OnInit {
  constructor(private documentDataService: DocumentDataService) {
  }

  private _documentDatas: DocumentData[];

  get documentDatas(): DocumentData[] {
    return this._documentDatas;
  }

  ngOnInit(): void {
    this._documentDatas = this.documentDataService.all();
    console.log('got ' + this.documentDatas.length + ' elements');
  }
}

import {Component, OnInit} from '@angular/core';
import {DocumentData} from '../../data/document-data';
import {DocumentDataService} from '../../services/document-data.service';

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
    this.documentDataService.all()
      .subscribe(documentDatas => {
        this._documentDatas = documentDatas;
        console.log('got ' + this.documentDatas.length + ' elements');
      });
  }
}

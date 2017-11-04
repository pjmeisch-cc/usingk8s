import {Injectable} from '@angular/core';
import {DocumentData} from './document-data';

@Injectable()
export class DocumentDataService {
  // mock implementation
  private documentDatas: DocumentData[];


  constructor() {
    this.documentDatas = [];
  }

  public all(): DocumentData[] {
    return this.documentDatas;
  }

  public add(documentData: DocumentData) {
    this.documentDatas.push(documentData);
  }

}

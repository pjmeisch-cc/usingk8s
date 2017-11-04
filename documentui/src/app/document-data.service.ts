import {Injectable} from '@angular/core';
import {DocumentData} from './document-data';
import {Observable} from 'rxjs/Observable';

import 'rxjs/add/observable/of';
import 'rxjs/add/observable/from';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/filter';

/**
 * service to access the backend API server.
 */
@Injectable()
export class DocumentDataService {
  // mock implementation
  private documentDatas: DocumentData[];


  constructor() {
    this.documentDatas = [];
  }

  /**
   * get all documents from the API server.
   * @returns {Observable<DocumentData[]>}
   */
  all(): Observable<DocumentData[]> {
    console.log('returning all data, ' + this.documentDatas.length);
    return Observable.of(this.documentDatas);
  }

  /**
   * add a document to the API server.
   * @param documentData
   */
  add(documentData: DocumentData) {
    let number = this.documentDatas.length + 1;
    documentData.id = number.toString();
    this.documentDatas.push(documentData);
  }

  /**
   * get a DocumentData with a given id
   * @param {string} id
   * @returns {Observable<DocumentData>}
   */
  get(id: string): Observable<DocumentData> {
    return this.all()
      .switchMap((docArray: DocumentData[]) => Observable.from(docArray))
      .filter(doc => doc.id === id);
  }
}

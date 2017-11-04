import {Injectable} from '@angular/core';
import {DocumentData} from './document-data';

@Injectable()
/**
 * service to access the backend API server.
 */
export class DocumentDataService {
  // mock implementation
  private documentDatas: DocumentData[];


  constructor() {
    this.documentDatas = [];
  }

  /**
   * get all documents from the API server.
   * @returns {DocumentData[]}
   */
  all(): DocumentData[] {
    console.log('returning all data, ' + this.documentDatas.length);
    return this.documentDatas;
  }

  /**
   * add a document to the API server.
   * @param documentData
   */
  add(documentData: DocumentData) {
    this.documentDatas.push(documentData);
  }

}

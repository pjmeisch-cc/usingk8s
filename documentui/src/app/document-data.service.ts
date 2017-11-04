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
  all(): Promise<DocumentData[]> {
    console.log('returning all data, ' + this.documentDatas.length);
    return Promise.resolve(this.documentDatas);
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
   * @returns {Promise<DocumentData>}
   */
  get(id: string): Promise<DocumentData> {
    return this.all().then(docs => docs.find(doc => doc.id === id));
  }
}

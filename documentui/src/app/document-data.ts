export class DocumentData {
  private _title: string;

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  private _content: string;

  get content(): string {
    return this._content;
  }

  set content(value: string) {
    this._content = value;
  }

  public toString() {
    let stripped = this._content;
    if (this._content) {
      stripped = this._content.substr(0, 10);
    }

    return `DocumentData (title: ${this._title}, content: ${stripped})`;
  }

  public isValid() {
    return this._title && this._content;
  }
}

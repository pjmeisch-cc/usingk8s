export class DocumentData {
  title: string;
  content: string;

  public toString = (): string => {
    let stripped = this.content;
    if (this.content) {
      stripped = this.content.substr(0, 10);
    }

    return `DocumentData (title: ${this.title}, content: ${stripped})`;
  }
}

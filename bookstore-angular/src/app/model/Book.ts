export interface Book {
  id: number;
  genre: string[];
  title: string;
  author: string[];
  price: number;
  coverUrl: string;
}

export interface BookSearch {
  docs: Book[];
  numFound: string;
  q: string;
  start: string;
}

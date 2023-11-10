export interface Book {
  key: string;
  type: string;
  title: string;
  author_name: string[];
  author_alternative_name: string[];
  ratings_average: number;
  cover_edition_key: string;
}

export interface BookSearch {
  docs: Book[];
  numFound: string;
  q: string;
  start: string;
}

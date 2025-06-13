import 'dart:convert';
import 'dart:io';

int calculate() {
  return 6 * 7;
}

void addBook(List<Map<String, dynamic>> books, Map<String, dynamic> book) {
  books.add(book);
}

Map<String, dynamic> askUserForBook() {
  print("Titre : ?");
  String? title = stdin.readLineSync(encoding: utf8);

  print("Auteur : ?");
  String? author = stdin.readLineSync(encoding: utf8);

  print("Date de publication : ?");
  String? releaseDate = stdin.readLineSync(encoding: utf8);

  print(" Lu ? : y/n ");
  dynamic read = stdin.readLineSync(encoding: utf8);

  while (read != "y" && read != "n") {
    print("Répondez uniquement par y ou n");
    read = stdin.readLineSync(encoding: utf8);
  }

  if (read == "y") {
    read = true;
  } else {
    read = false;
  }

  var book = {
    "titre": title,
    "auteur": author,
    "releaseDate": releaseDate,
    "lu": read,
  };
  return book;
}

Map<String, dynamic>? searchBooks(
  List<Map<String, dynamic>> books,
  String? title,
) {
  for (var book in books) {
    if (book["titre"] == title) {
      return book;
    }
  }
}

void listBooks(List<Map<String, dynamic>> books) {
  for (var book in books) {
    print(book);
  }
}

void deleteBook(List<Map<String, dynamic>> books, String? title) {
  Map<String, dynamic> bookToDelete = {};
  for (var book in books) {
    if (book["titre"] == title) {
      bookToDelete = book;
    }
  }
  books.remove(bookToDelete);
}

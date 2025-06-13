import 'dart:convert';
import 'dart:io';

import 'package:exo_livre/exo_livre.dart';

void main(List<String> arguments) {
  List<Map<String, dynamic>> books = [];
  var isRunning = true;
  books.add({
    "titre": "The way of kings",
    "auteur": "Brandon Sanderson",
    "année": "2003",
    "lu": true,
  });

  while (isRunning) {
    print('''
    \n
    1 - Ajouter un livre
    2 - Afficher tous les livres
    3 - Rechercher un livre par titre
    4 - Supprimer un livre par titre
    5 - Quitter
    \n
    ''');

    var userChoice = stdin.readLineSync();

    switch (userChoice) {
      case "1":
        books.add(askUserForBook());
      case "2":
        listBooks(books);
      case "3":
        print("Titre du livre que vous cherchez ?");
        var title = stdin.readLineSync();
        var book = searchBooks(books, title);

        if (book == null) {
          print("Aucun livre n'a ce nom");
        } else {
          print(book);
        }
      case "4":
        print("Titre du livre à supprimer ?");
        var title = stdin.readLineSync();
        deleteBook(books, title);
      case "5":
        isRunning = false;
    }
  }
}

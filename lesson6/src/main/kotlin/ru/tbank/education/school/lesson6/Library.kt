package ru.tbank.education.school.lesson6

// Класс книги
data class Book(val title: String, val author: String, val year: Int, val genre: String)

// Класс пользователя
data class User(val name: String, val id: Int)

// Класс библиотеки
class Library {
    private val catalog = mutableListOf<Book>()
    private val users = mutableSetOf<User>()
    private val borrowedBooks = mutableMapOf<User, MutableList<Book>>()

    fun addBook(book: Book) {
       catalog.add(book)
    }

    fun registerUser(user: User) {
        catalog.add(user)
    }

    fun lendBook(user: User, book: Book) {
       borrowedBooks[user].add(book)
    }

    fun returnBook(user: User, book: Book) {
        borrowedBooks[user].remove(book)
    }

    fun listBooksSortedByYear() {
       return catalog.sortedBy { it.year }
    }

    fun findBooksByAuthor(author: String) {
        val filtered = {it}
    }

    fun groupBooksByGenre() {
        // TODO: сгруппировать книги по жанрам
    }

    fun userBooks(user: User) {
        // TODO: вывести список книг у пользователя
    }

    fun mostActiveUser() {
        // TODO: найти пользователя с наибольшим числом книг
    }

    fun genreStatistics() {
        // TODO: вывести количество книг по жанрам
    }
}

fun main() {
    val library = Library()

    // Пример работы с системой:
    // 1. Добавить книги
    // 2. Зарегистрировать пользователей
    // 3. Выдать и вернуть книги
    // 4. Вызвать методы отчетов
}

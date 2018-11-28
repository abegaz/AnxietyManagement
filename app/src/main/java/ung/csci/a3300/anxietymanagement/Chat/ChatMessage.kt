package ung.csci.a3300.anxietymanagement.Chat

class ChatMessage(val id: String, val text: String, val fromID: String, val toId: String, val timestamp: Long){
    constructor() : this("", "", "", "", -1)
}
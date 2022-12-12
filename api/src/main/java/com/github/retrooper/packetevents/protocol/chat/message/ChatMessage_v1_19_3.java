package com.github.retrooper.packetevents.protocol.chat.message;

import com.github.retrooper.packetevents.protocol.chat.LastSeenMessages;
import com.github.retrooper.packetevents.protocol.chat.filter.FilterMask;
import net.kyori.adventure.text.Component;

import java.time.Instant;
import java.util.UUID;

public class ChatMessage_v1_19_3 extends ChatMessage {
    UUID senderUUID;
    int index;
    byte[] signature;
    String plainContent;
    Instant timestamp;
    long salt;
    LastSeenMessages lastSeenMessages;
    Component unsignedChatContent;
    FilterMask filterMask;
    ChatMessage_v1_19_1.ChatTypeBoundNetwork chatType;

    public ChatMessage_v1_19_3(UUID senderUUID, int index, byte[] signature, String plainContent, Instant timestamp, long salt, LastSeenMessages lastSeenMessages, Component unsignedChatContent, FilterMask filterMask, ChatMessage_v1_19_1.ChatTypeBoundNetwork chatType) {
        super(unsignedChatContent, chatType.getType());
        this.senderUUID = senderUUID;
        this.index = index;
        this.signature = signature;
        this.plainContent = plainContent;
        this.timestamp = timestamp;
        this.salt = salt;
        this.lastSeenMessages = lastSeenMessages;
        this.unsignedChatContent = unsignedChatContent;
        this.filterMask = filterMask;
        this.chatType = chatType;
    }

    public UUID getSenderUUID() {
        return senderUUID;
    }

    public void setSenderUUID(UUID senderUUID) {
        this.senderUUID = senderUUID;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public String getPlainContent() {
        return plainContent;
    }

    public void setPlainContent(String plainContent) {
        this.plainContent = plainContent;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public long getSalt() {
        return salt;
    }

    public void setSalt(long salt) {
        this.salt = salt;
    }

    public LastSeenMessages getLastSeenMessages() {
        return lastSeenMessages;
    }

    public void setLastSeenMessages(LastSeenMessages lastSeenMessages) {
        this.lastSeenMessages = lastSeenMessages;
    }

    public Component getUnsignedChatContent() {
        return unsignedChatContent;
    }

    public void setUnsignedChatContent(Component unsignedChatContent) {
        this.unsignedChatContent = unsignedChatContent;
    }

    public FilterMask getFilterMask() {
        return filterMask;
    }

    public void setFilterMask(FilterMask filterMask) {
        this.filterMask = filterMask;
    }

    public ChatMessage_v1_19_1.ChatTypeBoundNetwork getChatType() {
        return chatType;
    }

    public void setChatType(ChatMessage_v1_19_1.ChatTypeBoundNetwork chatType) {
        this.chatType = chatType;
    }
}
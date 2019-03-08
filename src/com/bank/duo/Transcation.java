package com.bank.duo;

public interface Transcation {
void deposit(long aadhar,long balance);
void withdraw(long aadhar,long balance);
void balance(long aadhar,long balance);
}

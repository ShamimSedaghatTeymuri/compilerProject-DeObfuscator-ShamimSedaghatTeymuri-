# CompilerProject-Obfuscator--ShamimSedaghatTeymuri-
این پروژه یک obfuscator برای زبان MiniC است که با استفاده از ANTLR4 کد را به Parse tree و سپس به AST تبدیل میکند و بعد از اعمال تکنیک های مبهم سازی کد نهایی را تولید کرده و آن را از نظر زمان اجرا ، سایز و خروجی با کد اصلی مقایسه میکند . 

## تکنیک های استفاده شده 
1. تغییر نام توابع و متغیر ها 
2. اضافه کردن کد های مرده 
3. تبدیل عبارات ساده به عبارات معادل پیچیده تر

## ساختار فایل ها 
- Main.java شروع برنامه 
- ASTBuilderVisitor.java  ساخت AST از Parse Tree
- ObfuscatorVisitor.java اعمال تکنیک های مبهم سازی 
- input.mc فایل کد اولیه 
- output.mc فایل کد مبهم شده 
- PerformanceComparator مقایسه عملکر کد اصلی و کد مبهم شده 

## ساختار پروژه 
CompilerProject-Obfuscator/
│
├── ast/ # کلاس‌های AST و Visitorها (Obfuscator و CodeGenerator)
├── parser/ # فایل‌های تولید شده توسط ANTLR (MiniCLexer، MiniCParser)
├── input.mc # فایل ورودی کد Mini-C
├── output.mc # خروجی مبهم‌شده
├── Main.java # کلاس اصلی اجرای پروژه
├── PerformanceCompartor # بررسی و مقایسه عملکرد کد اصلی و کد مبهم شده 
└── README.md # مستندات پروژه

## نیازمندی های پروژه 
- java 17  یا بالاتر 
- ANTLR 4.9.2
- کامپایلر GCC برای اجرای کد ها و بررسی عملکردشون 


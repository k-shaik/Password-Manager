# Password-Manager

<br/>
<div align="center">
<a href="https://github.com/k-shaik/PasswordManager">
<img src="https://i.imghippo.com/files/GPCN3387nh.png" alt="Logo" width="80" height="80">
</a>
<h3 align="center">Password Manager</h3>
<p align="center">
A Secure and User-Friendly Password Management Application.
</p>
</div>

---

## 🚀 About The Project

**Password Manager** is a Java-based application designed to securely store and retrieve passwords for various websites. It uses the Advanced Encryption Standard (AES) to ensure that your sensitive data remains protected.

---

## 🛠️ Key Features

- **Add Passwords**: Securely store passwords for different websites.
- **Retrieve Passwords**: Retrieve stored passwords using the website name.
- **Encryption & Decryption**: Protect passwords using AES encryption.
- **Dynamic Key Generation**: Generate a secure AES key at runtime for enhanced security.
- **User-Friendly Interface**: Simple, text-based interface for easy interaction.
- **Error Handling**: Includes input validations and meaningful error messages.
- **Exit Confirmation**: Avoid accidental exits by confirming user intent.

---

## 🔍 How It Works

1. **Encryption**: Passwords are encrypted using a dynamically generated AES key before being stored.
2. **Decryption**: Encrypted passwords are decrypted with the same AES key upon retrieval.
3. **Storage**: Passwords are stored in a `HashMap` with the website name as the key.

---

## 🧰 Requirements

- Java 8 or above.

---

## 🏗️ How to Run

1. **Clone the repository** or copy the source code into your Java IDE.
2. **Compile and run the PasswordManager class**.
3. **Follow the console prompts** to add or retrieve passwords.

---

## 📈 Future Improvements

- **Persistent Storage**: Save passwords in a database or file system for long-term storage.
- **User Authentication**: Add a login system to secure access to the password manager.
- **Password Strength Analysis**: Provide feedback on the strength of user passwords.
- **Graphical User Interface (GUI)**: Enhance usability with a visual interface.

---

## 🤝 Contributing

Contributions are welcome to improve **Password Manager**. Here's how you can get involved:

1. **Fork the repository**.
2. **Create a feature branch**:
      git checkout -b feature/NewFeature

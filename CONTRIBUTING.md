
# 🤝 Contributing to *The World's Hardest Game (Java Remake)*

First off — **thank you for taking the time to contribute!** 💪  
This project is a Java remake of *The World's Hardest Game*, built from scratch as part of a university course and later improved by the community.

---

## 🧱 Project Overview

This game recreates the original *The World’s Hardest Game* with modern features such as:

- User **login/register system** (via MySQL)
- **Leaderboard** tracking best times
- **Collision-based entity system**
- **Clean, object-oriented** Java codebase

The game runs on **Java Swing** for its GUI and uses **MySQL** for user data (optional).

---

## 🧩 How to Contribute

### 1. Fork & Clone the Repository

```bash
git clone https://github.com/<your-username>/worldshardestgamejava.git
cd worldshardestgamejava
````

### 2. Create a New Branch

```bash
git checkout -b feature/your-feature-name
```

### 3. Make Your Changes

Before committing, make sure:

* The game compiles without errors.
* Movement, collisions, and other game mechanics still work.
* Code follows the existing structure and naming conventions.

### 4. Test Thoroughly

Please test both:

* **Offline mode** (admin login without MySQL)
* **Database mode** (user registration & leaderboard)

### 5. Commit & Push

Use clear and descriptive commit messages.

```bash
git add .
git commit -m "Add: diagonal movement support"
git push origin feature/your-feature-name
```

### 6. Open a Pull Request (PR)

Once ready, create a PR on the [main repository](https://github.com/emrhngngr/worldshardestgamejava) and explain:

* What was added or fixed
* Why it’s needed
* How to test it

---

## 🧠 Code Style Guidelines

To keep the codebase clean and readable:

* **Indentation:** 4 spaces
* **Class names:** `PascalCase`
* **Variables & methods:** `camelCase`
* **Constants:** `UPPER_CASE`
* Add comments for complex logic
* Avoid “magic numbers” — use constants or configuration values

---

## 🐞 Reporting Bugs

If you find a bug, please open an [Issue](https://github.com/emrhngngr/worldshardestgamejava/issues/new) and include:

* Description of the problem
* Steps to reproduce
* Expected vs. actual behavior
* Screenshots or logs (if relevant)
* Your OS and Java version

Example:

```text
Character cannot move diagonally when pressing W + D.
Expected: Character moves northeast.
Actual: Character only moves in one direction.
```

---

## 🌟 Suggesting New Features

Have an idea (e.g., new levels, music, settings menu, or smoother movement)?
Open an issue with the **“enhancement”** label and describe your idea in detail.
Feel free to attach sketches or mockups!

---

## 🧰 Local Development Setup

1. Install **Java 17+**
2. Use an IDE such as **IntelliJ IDEA** or **Eclipse**
3. Run directly from your IDE
4. (Optional) Set up MySQL if you want:

   * User registration
   * Leaderboard system

> 💡 Default admin login (no database needed):
> **Username:** `admin`
> **Password:** `123`

---

## 📜 License

This project is released under the **MIT License**, meaning you can freely use, modify, and distribute it for any purpose.
If you find this project helpful, please give it a ⭐ on GitHub — it really helps!

---

## 💬 Questions?

If something isn’t clear or you’d like to discuss a change:

* Open an **issue**
* Start a **discussion**
* Or reach out directly via GitHub

Thanks again for contributing and helping make this project even better! ❤️
— *Emirhan Güngör*


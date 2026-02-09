# 🚗 Car Wash Management System – Spring Boot

A backend **Spring Boot REST API** for managing a **car wash service**, where **customers are mapped to cleaners based on area availability**, with support for **packages, service types, start/end dates, and full CRUD operations**.

This project follows **industry-standard layered architecture** and uses **MySQL** for persistent storage.

---

## 📌 Features

### 👤 Customer Management
- Create, read, update, delete customers
- Choose package type (Weekly / Monthly / Yearly)
- Choose service type (Full Clean / Outer Clean + Watering)
- Store start and end dates
- Assign a cleaner automatically based on area

### 🧹 Cleaner Management
- Create, read, update, delete cleaners
- Store experience, salary, and working area
- One cleaner can serve multiple customers

### 🔗 Customer–Cleaner Mapping
- Customers are mapped to cleaners **only if both belong to the same area**
- Mapping stored using a **foreign key (`cleaner_id`)**
- Clean, user-friendly response showing:
  - Customer details
  - Cleaner details
  - Package & service info
  - Start and end dates

---

### ALL CRUD OPERATIONS

---

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/ffc72b4e-4cd6-4a8b-a115-7604f3d049aa" />
<img width="954" height="334" alt="image" src="https://github.com/user-attachments/assets/97598a55-50d0-4f6a-a0d2-790616860c40" />

---

### Check Availability Of Cleaner For Customer

---

<img width="955" height="413" alt="image" src="https://github.com/user-attachments/assets/2fb6d62d-113b-440c-9856-e23b4001a372" />

---


### CustomerCleanerResponse

---

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/9aec5a04-d225-4dee-84a8-a35fd0ac19bb" />



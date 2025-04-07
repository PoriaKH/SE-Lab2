## Code Smells Identified

| # | Issue | Description |
|--|-------|-------------|
| 1 | **God Class** | `PaymentProcessor` has too many responsibilities: validation, processing, logging, and integration. |
| 2 | **Hardcoded Configuration** | API endpoints are stored directly in a config map and used directly. |
| 3 | **Long Conditional / Switch** | Uses `switch(paymentType)` instead of polymorphism. |
| 4 | **Long Method** | The `validatePayment` method handles multiple concerns and is difficult to extend. |
| 5 | **Code Duplication** | Similar logic repeated across different `processXXX` methods. |
| 6 | **Lack of Abstraction** | All payment types and gateway logic are embedded in a single class. |
| 7 | **Tight Coupling** | Direct dependencies on logic for each payment type within a monolithic structure. |

---

## Violations of SOLID Principles

| Principle | Violation |
|----------|-----------|
| **S - Single Responsibility** | Class `PaymentProcessor` handles multiple tasks that should be in separate classes. |
| **O - Open/Closed** | Adding a new payment type requires modifying the `switch` block. |
| **L - Liskov Substitution** | Not applicable yet, but current structure doesn't support interchangeability of types. |
| **I - Interface Segregation** | No interfaces exist for splitting payment or gateway responsibilities. |
| **D - Dependency Inversion** | Class depends on concrete logic instead of abstractions (e.g. API calls, payment validation). |

---

## Suggested Documentation or Inline Comments

```java
// Code Smells Identified:
// 1. God Class - PaymentProcessor does too much.
// 2. Hardcoded endpoints in configuration map.
// 3. Switch-case structure instead of polymorphism.
// 4. Duplicated logic in different processXXX methods.
// 5. Violates SRP, OCP, DIP from SOLID principles.
```

---


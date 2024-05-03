# Typescript Guidelines

## Naming Conventions

1. Use PascalCase for type names.
2. Do not use `I` as a prefix for interface names.
3. Use PascalCase for enum values.
4. Use camelCase for function names.
5. Use camelCase for property names and local variables.
6. Do not use `_` as a prefix for private properties.
7. Use whole words in names when possible.

## Types

1. Do not export types/functions unless you need to share it across multiple components.
2. Shared types should be defined in `*.types.ts`.
3. Within a file, type definitions should come first.

## Strings

1. Use double quotes for strings.
2. All strings visible to the user need to be localized.

## Style

1. Use arrow functions over anonymous function expressions.
2. Only surround arrow function parameters when necessary.\
   For example, `(x) => x + x` is wrong but the following are correct:
   * `x => x + x`
   * `(x,y) => x + y`
   * `<T>(x: T, y: T) => x === y`
3. Always surround loop and conditional bodies with curly braces. Statements on the same line are allowed to omit braces.
4. Open curly braces always go on the same line as whatever necessitates them.
5. Parenthesized constructs should have no surrounding whitespace.\
   A single space follows commas, colons, and semicolons in those constructs. For example:
   * `for (var i = 0, n = str.length; i < 10; i++) { }`
   * `if (x < 10) { }`
   * `function f(x: number, y: string): void { }`
6. Use a single declaration per variable statement\
   (i.e. use `var x = 1; var y = 2;` over `var x = 1, y = 2;`).
7. `else` goes on a separate line from the closing curly brace.
8. Use 4 spaces per indentation.

\

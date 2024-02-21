"use strict";
var Hello;
(function (Hello) {
    Hello[Hello["Hi"] = 0] = "Hi";
    Hello[Hello["Hello"] = 1] = "Hello";
    Hello[Hello["Whatsup"] = 2] = "Whatsup";
})(Hello || (Hello = {}));
console.log(Hello.Whatsup);
//# sourceMappingURL=index.js.map
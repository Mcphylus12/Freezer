# vue-experiments

Experimentations for building a highly configureable VUE front end.

> I know some of this is reinventing the wheel but this is an education exercise as much as anything else for me.

- [x] Layout Engine - A single component that renders a configureable layout based on a javascript object defined in config. Supports loading vue components async so only components and their dependencies are loaded onto the site.
- [x] Data retrieval abstraction for development with no back end - All done by cant work out a nice way to make the decision of real or mock based on cli args
- [ ] Dynamic collection management system - Renders a list based on a JS array and runs strategies to calculate dynamic components to generate for each item
- [ ] Pipeable observeables with integrated caching for developping SPA's
- [ ] A service/component for tracking interests to manage and display data recieved via polling or websockets
- [ ] A tool box of components built to be highly parameterised for use with above systems

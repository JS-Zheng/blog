"use strict";

function _asyncToGenerator(fn) { return function () { var gen = fn.apply(this, arguments); return new Promise(function (resolve, reject) { function step(key, arg) { try { var info = gen[key](arg); var value = info.value; } catch (error) { reject(error); return; } if (info.done) { resolve(value); } else { return Promise.resolve(value).then(function (value) { step("next", value); }, function (err) { step("throw", err); }); } } return step("next"); }); }; }

var vm = new Vue({
    el: "#container",
    data: {
        res: null,
        loading: true,
        error: null
    },
    components: {
        "gank-img": {
            props: ['url'],
            template: '<img class="gank-img" :src="url">'
        }
    },
    created: function () {
        var _ref = _asyncToGenerator(regeneratorRuntime.mark(function _callee() {
            var res;
            return regeneratorRuntime.wrap(function _callee$(_context) {
                while (1) {
                    switch (_context.prev = _context.next) {
                        case 0:
                            _context.prev = 0;
                            _context.next = 3;
                            return fetch('https://gank.io/api/random/data/福利/20');

                        case 3:
                            res = _context.sent;
                            _context.next = 6;
                            return res.json();

                        case 6:
                            this.res = _context.sent;

                            this.loading = false;
                            _context.next = 13;
                            break;

                        case 10:
                            _context.prev = 10;
                            _context.t0 = _context["catch"](0);

                            this.error = _context.t0;

                        case 13:
                        case "end":
                            return _context.stop();
                    }
                }
            }, _callee, this, [[0, 10]]);
        }));

        function created() {
            return _ref.apply(this, arguments);
        }

        return created;
    }()
});
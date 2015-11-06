var express = require('express');
var consts = require('../json/consts.json');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { consts: consts });
});

module.exports = router;

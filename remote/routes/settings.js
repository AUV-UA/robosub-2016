var express = require('express');
var consts = require('../json/consts.json');
var router = express.Router();

router.get('/', function(req, res, next) {
  res.render('settings', {consts: consts });
});

module.exports = router;

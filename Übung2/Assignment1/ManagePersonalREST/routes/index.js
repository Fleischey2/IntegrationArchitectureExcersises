var express = require('express');
var router = express.Router();

let salesmen= [
  { id: 1, name: "John Doe", socialPerformanceRecords: []},
  { id: 2, name: "John Pork", socialPerformanceRecords: []}
];

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.get('/salesmen', function(req, res) {
  res.json(salesmen);
});

router.get('/salesman/:id', function(req, res) {
  const salesman = salesmen.find(salesman => salesman.id === parseInt(req.params.id));
  if(!salesman) {
    return res.status(400).json({message: "No salesman found with id " + req.params.id})
  }
  res.json(salesman);
});

router.delete('/salesman/:id', function(req, res) {
  const salesmanIndex = salesmen.findIndex(salesman => salesman.id === parseInt(req.params.id));
  if(salesmanIndex === -1) {
    return res.status(400).json({message: "No salesman found with id " + req.params.id})
  }
  salesmen.splice(salesmanIndex, 1);
  res.status(200).json({message: "Success!"})
});

router.post('/salesman/:id/addSocial-perfomance', function(req, res) {
  const salesman = salesmen.find(salesman => salesman.id === parseInt(req.params.id));
  if(!salesman) {
    return res.status(400).json({message: "No salesman found with id " + req.params.id})
  }
  //for demonstration simplified
  const socialPerfomance = {
    year: req.body.year
  }

  salesman.socialPerformanceRecords.push(socialPerfomance);
  res.status(200).json({message: "Success!"})
});

router.get('salesman/:id/getSocial-perfomance', function(req, res) {
  const salesman = salesmen.find(salesman => salesman.id === parseInt(req.params.id));
  if(!salesman) {
    return res.status(400).json({message: "No salesman found with id " + req.params.id})
  }
  res.status(200).json(salesman.socialPerformanceRecords);
});

module.exports = router;

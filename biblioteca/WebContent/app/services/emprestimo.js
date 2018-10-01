APP.factory("EmprestimoService", function($resource) {
  return $resource('http://localhost:8080/biblioteca/api/emprestimos/:id', {id:'@_id'},{
    update: {
      method  : 'PUT',
      url     : 'http://localhost:8080/biblioteca/api/emprestimos/:id',
      params  : { id: '@id' },
      isArray : false 
    },
  delete: {
      method  : 'DELETE',
      url     : 'http://localhost:8080/biblioteca/api/emprestimos/:id',
      params  : { id: '@id' },
      isArray : false 
    }
  });
});

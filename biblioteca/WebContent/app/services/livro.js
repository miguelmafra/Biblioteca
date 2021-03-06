APP.factory("LivroService", function($resource) {
  return $resource('http://localhost:8080/biblioteca/api/livros/:id', {id:'@_id'},{
    update: {
      method  : 'PUT',
      url     : 'http://localhost:8080/api/livros/:id',
      params  : { id: '@id' },
      isArray : false
    }
  });
});

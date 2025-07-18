curl -X POST -s http://localhost:8080/cursos \
    -H "Content-Type: application/json" \
    -d '{"nombre":"Matemáticas","descripcion":"Curso obligatorio para el pensum de ingeniería"}' \
    | jq
   
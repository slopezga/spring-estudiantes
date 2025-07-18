curl -X POST http://localhost:8080/inscripciones \
     -H "Content-Type: application/json" \
     -d '{"estudianteId": 8, "cursoId": 2}' \
    | jq

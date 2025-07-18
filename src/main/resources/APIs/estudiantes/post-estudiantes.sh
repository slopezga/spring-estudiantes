curl -X POST http://localhost:8080/estudiantes \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juliana","edad":24,"promedio":4.7}' \
  | jq
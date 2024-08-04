const express = require('express');
const bodyParser = require('body-parser');
const jwt = require('jsonwebtoken');
const cors = require('cors');
require('dotenv').config();

const app = express();
const port = 3000;

// Configurar CORS
app.use(cors({
  origin: 'http://localhost:5173',  // Permite solicitudes desde el puerto del frontend
  methods: ['GET', 'POST'],         // Métodos HTTP permitidos
  allowedHeaders: ['Content-Type', 'Authorization'] // Encabezados permitidos
}));

// Middleware para parsear JSON
app.use(bodyParser.json());

// Usuario de ejemplo
const user = {
  id: 1,
  username: 'testuser',
  password: 'password123'
};

// Ruta de inicio de sesión
app.post('/login', (req, res) => {
  const { username, password } = req.body;

  // Verificar las credenciales del usuario
  if (username === user.username && password === user.password) {
    // Generar un token JWT
    const token = jwt.sign({ id: user.id, username: user.username }, process.env.JWT_SECRET, { expiresIn: '1h' });
    return res.json({ token });
  }

  res.status(401).json({ message: 'Credenciales incorrectas' });
});

// Ruta protegida (solo accesible con token válido)
app.get('/dashboard', verifyToken, (req, res) => {
  res.json({ message: 'Bienvenido al dashboard' });
});

// Middleware para verificar el token
function verifyToken(req, res, next) {
  const bearerHeader = req.headers['authorization'];

  if (typeof bearerHeader !== 'undefined') {
    const bearerToken = bearerHeader.split(' ')[1];
    jwt.verify(bearerToken, process.env.JWT_SECRET, (err, authData) => {
      if (err) {
        return res.sendStatus(403);
      }
      req.authData = authData;
      next();
    });
  } else {
    res.sendStatus(403);
  }
}

// Iniciar el servidor
app.listen(port, () => {
  console.log(`Servidor escuchando en http://localhost:${port}`);
});

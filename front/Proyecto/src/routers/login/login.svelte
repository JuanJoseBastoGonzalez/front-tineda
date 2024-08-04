<script>
    import { onMount } from 'svelte';
    import { navigate } from 'svelte-routing';
  import  './Login.css'
    let username = '';
    let password = '';
    let token = '';
  
    async function login() {
        if (username == ""){
alert("Ingrese un usuario ")
        }else if (password == "" ){
            alert("Ingrese una contraseña")
        }else{
        try {
            const response = await fetch('http://localhost:3000/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ username, password })
            });
  
            if (!response.ok) {
                const errorData = await response.json();
                console.error('Error:', errorData.message);
                return;
            }
  
            const data = await response.json();
            if (data.token) {
                token = data.token;
                localStorage.setItem('token', token); // Guardar el token en localStorage
                console.log('JWT Token:', token);
                navigate('/Dashboard'); // Redirige al Dashboard después del inicio de sesión
            } else {
                console.error('Token no encontrado en la respuesta');
            }
        } catch (error) {
            console.error('Error en la solicitud:', error);
        }
    }
}
    onMount(() => {
        // Recuperar el token de localStorage si existe
        token = localStorage.getItem('token') || '';
    });
  </script>
  
  <main class="pg">
    <h1 class="tp">Login</h1>
    <form on:submit|preventDefault={login}>
        <label>
            
            <input class="it" type="text" bind:value={username} placeholder="Username" />
        </label>
        <br />
        <label>
            
            <input class="it" type="password" bind:value={password} placeholder="password" />
        </label>
        <br />
        <button type="submit">Login</button>
    </form>
  
 
</main>
  
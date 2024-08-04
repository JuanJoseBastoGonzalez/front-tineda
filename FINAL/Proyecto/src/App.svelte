<!-- App.svelte -->
<script>
    import { Router, Route } from 'svelte-routing';
    import Login from './routers/login.svelte';
    import Dashboard from './routers/dashboard.svelte';
  </script>
  
  <Router>
    <Route path="/" component={Login} />
    <Route path="/Dashboard" component={Dashboard} />
  </Router>
  
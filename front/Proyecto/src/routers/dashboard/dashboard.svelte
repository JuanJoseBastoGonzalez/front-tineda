<!-- About.svelte -->
<script>
  import { link } from "svelte-spa-router";
  import Navbar from '../../components/nav.svelte'
  import { show } from '../../stores/Stores';
  import Sidebar from "../../components/Sidebar.svelte";
  </script>
<div class="m0">
  <div>
    <Navbar/>
  </div> 
  <div>
    {#if $show}
    <Sidebar/>
    {/if}
  </div>
  <h1>About</h1>
  <a  href ="/" use:link>fsdfs</a>
</div>

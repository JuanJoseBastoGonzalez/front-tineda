<!-- About.svelte -->
<script>
  import { link } from "svelte-spa-router";
  import Navbar from '../../components/nav.svelte'
  import { show } from '../../stores/Stores';
  import Sidebar from "../../components/Sidebar.svelte";
  import "./Dashboard.css"
  </script>
<div class="m0">
  <div>
    <Navbar/>
  </div> 
  <div class="f">
    {#if $show}
    <Sidebar/>
    {/if}
    fsdafasdfasf
  </div>
<!-- 
  <a  href ="/" use:link>fsdfs</a> -->
</div>

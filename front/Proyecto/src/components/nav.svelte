<script lang="ts">
  import userImage from "../assets/user.png";
  import { show } from '../stores/Stores'; 
  import "../styles/global.css";

  let isVisible: boolean = false;

  function toggShow() {
    show.update(value => !value);
  }
  function toggleSidebar() {
    isVisible = !isVisible;
  }


</script>

<style lang="less">
  .nav {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: rgb(87, 87, 87);
    padding: 0 10px;
    height: 60px;
  }

  .lu {
    height: 3rem;
    width: auto;
  }

  .bl {
    border-radius: 50%;
    height: 3rem;
    width: 3rem;
    margin: 10px;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: white;
    border: none;
    cursor: pointer;
  }

  .bl:hover {
    background-color: #ccc;
  }
</style>

<aside>
  <div class="nav">
    <div>
      <button class="bl" on:click={toggShow}>
        <img class="lu" src={userImage} alt="User Image" />
      </button>
    </div>
    <div>Dashboard</div>
    <div>
      <button class="bl" on:dblclick={toggleSidebar}>
        <img class="lu" src={userImage} alt="User Image" />
      </button>
    </div>
  </div>

 
  
</aside>

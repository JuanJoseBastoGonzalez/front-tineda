<script lang="ts">
    function isShowEm(){
 alert("empleados")   
}
</script>

<div class="fc">
    <div>
       <p class="cp" on:click={isShowEm}>empleados</p> 
    </div>
    <div>
       <p class="cp" on:click={isShowEm}>empleados</p> 
    </div>
    <div>
       <p class="cp" on:click={isShowEm}>empleados</p> 
    </div>
    <div>
       <p class="cp" on:click={isShowEm}>empleados</p> 
    </div>
    <div>
       <p class="cp" on:click={isShowEm}>empleados</p> 
    </div>
   
</div>

<style lang="less">
    .fc {
        display: grid;
        justify-content: center;
        align-items: center;
        width: 15rem;
        gap: 3rem;
        padding: 3px;
        background-color: gold;
        height: 100%;
    }
</style>

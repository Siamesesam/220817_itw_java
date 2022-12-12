/**
 *  team.js
 *  팀 가입 시 비밀번호 입력. 시 가입가능
 *  /home.html 에 포함됨.
 */
 window.addEventListener('DOMContentLoaded', () => {
   
    const btnTeamJoinner = document.querySelector('#btnTeamJoinner');
    btnTeamJoinner.addEventListener('click', joinnerTeam);

    function joinnerTeam() {
        
    }
    
    const divJoinners = document.querySelector('#joinners');
    
    function getTeam(event) {
        
        const tid = event.target.getAttribute('data-tid');
        
        axios
        .get('/api/team/' + tid)
        .then(response => { showModal(response.data) })
        .catch(err => { console.log(err) });
    }
    
    const divModal = document.querySelector('#teamJoinModal');
    const teamJoinModal = new bootstrap.Modal(divModal);
    const modalTeamJoinId = document.querySelector('#modalTeamJoinId');
    const modalTeamJoinText = document.querySelector('#modalTeamJoinText');
    const modalBtnEntry = document.querySelector('#modalBtnEntry');
    
    function showModal(team) {
        
        modalTeamJoinId.value = team.teamId;
        
        teamJoinModal.show();
        
    }
    
    modalBtnEntry.addEventListener('click', entryTeamJoin);
    
    function entryTeamJoin(event) {
        const teamJoinId = modalTeamJoinId.value;
        
        axios
            .entry('/api/team/' + teamJoinId)
            .then(response => {
                alert(`#${response.data} 댓글 삭제 성공`);
            })
            .catch(err => { console.log(err) })
            .then(function () {
                teamJoinModal.hide()
            })
    } 
 
    
    
});
 
 
 
 
 
 
 
 
 
 
 
 
 
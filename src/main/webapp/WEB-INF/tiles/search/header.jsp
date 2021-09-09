<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function() {
	
	/* 검색어 세팅 */
	$('#search-box').val('${query}');
	
	/* 검색 버튼 클릭 이벤트 */
	$('.search-btn, .search-btn-sub').click(function() {
		
		fn_search();
	});
	
	/* 검색 Enter 이벤트 */
	$('#search-box').keydown(function(event) {
	
		if(event.keyCode === 13) {
			
			fn_search();
		}
	});
});

function fn_search() {
	
	const query = $('#search-box').val();
	if(fn_queryCheck(query)) return;
	window.location.href = '/search/' + '${page}' + '?query=' + query;
}

function fn_queryCheck(query) {
	
	const query_check = query.replaceAll(' ', '');
	
	if(query_check === '' || query_check === null || query_check === undefined) {
		
		$('.modal').modal('show');
		return true;
	}
}
</script>

<div class="container header">
	<div class="row">
		<div class="col-sm-2 wrap-logo text-center">
			<a href="/search" class="logo">WOONI</a>
		</div>
		<div class="wrap-search">
            <div class="input-group" id="adv-search">
                <input type="text" id="search-box" class="form-control" placeholder="Search" />
                <div class="input-group-btn">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-success search-btn"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                    </div>
                </div>
          	</div>
        </div>
	</div>
</div>	

<div class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">경고</h4>
			</div>
			<div class="modal-body">
				<p>검색어를 입력해주세요!</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>